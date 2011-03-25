(ns ryulogy.core
  (:use compojure.core)
  (:use hiccup.core)
  (:use hiccup.form-helpers)
  (:use ring.adapter.jetty)
  (:use ring.middleware.file)
  (:require [compojure.route :as route])
  )

(defn home
  ([] (html (form-to [:POST "/"] 
                     (text-field :name "CoolKid"))))
  )

(defn greet
  ([name] (html 
            [:img {:src ""}]
            [:p (str "Hello " name "!" )]
            [:a {:href "/"} "Home"]))
  )

(defroutes main-routes
           (GET "/" [] (home))
           (GET "/:igama" [igama] (greet igama))
           (POST "/" [name] (greet name))
           (route/not-found "PAGE NOT FOUND")
           )

(def app
  (wrap-file #'main-routes "public"))

