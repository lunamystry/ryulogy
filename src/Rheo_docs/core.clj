(ns Rheo_docs.core
  (:use compojure.core)
  (:use hiccup.core)
  (:use hiccup.form-helpers)
  (:require [compojure.route :as route]
            [compojure.handler :as handler])
  )

(def app
  (handler/site main-routes)
  )

(defn greet
      ([] (html (form-to [:POST "/"] 
                          (text-field :name "CoolKid"))))
      ([name] (html 
                [:p (str "Hello " name "!" )]
                [:a {:href "/"} "Home"]))
      )

(defroutes main-routes
           (GET "/" [] (greet))
           (GET "/:igama" [igama] (greet igama))
           (POST "/" [name] (greet name))
           (route/resources "/")
           (route/not-found "PAGE NOT FOUND")
           )


