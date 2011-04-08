(ns ryulogy.core
  (:use compojure.core)
  (:use hiccup.core)
  (:use hiccup.form-helpers)
  (:use ring.adapter.jetty)
  (:use ring.middleware.file)
  (:require [compojure.route :as route]))

(defn show-landing-page
  ([] (html (form-to [:POST "/"] 
                     (text-field :name "CoolKid")))))

(defn fetch-doc-content [file-name]
  " Description: Reads file from the documentation folder
     with name = filename.rst and returns it as a string
   Leonard's worry: This means it will be restricted to one 
     format of text, in this case text" 
  (try
    (slurp (str "public/docs/" file-name ".rst"))
    (catch Exception e (prn "in catch"))
    (finally (prn "in finally"))))

(defn serve-cms-content  
  " Description: generates html from data returned by the 
       fetch-doc-content function
    Leonard's worry: Is this now coupled to fetch-doc-content?"
  [content-name]
  (html [:div 
         [:h1 content-name]
         [:p (fetch-doc-content content-name)]]))

(defn demo-serve-all []
  ; Description: This is to show, and test that multiple docs
  ;   content may be shown.
  (html [:div {:id "demo-wrapper"}
         (serve-cms-content "contacts")
         (serve-cms-content "features")]))

(defn greet
  ; Description: Generates html greeting with a picture of a 
  ;  girl covering her face. 
  ([name] (html 
            [:img {:src "images/my_girl.jpg" :width "100px"}]
            [:p (str "Hello " name "!" )]
            [:a {:href "/"} "Home"])))

(defroutes main-routes
           (GET "/" [] (show-landing-page))
           (GET "/cms/serve-all" [] (demo-serve-all))
           (GET "/cms/:content-name" [content-name] (serve-cms-content content-name))
           (GET "/:igama" [igama] (greet igama)) ; Kept cause I like it
           (POST "/" [name] (greet name))
           (route/not-found "PAGE NOT FOUND"))

(def app
  (wrap-file #'main-routes "public"))

