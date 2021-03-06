(defproject ryulogy "11.06"
  :description "documentation system"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [compojure "0.4.1"]
                 [ring/ring-core "0.3.1"]
                 [ring/ring-servlet "0.3.1"]
                 [hiccup "0.3.0"]
                 [congomongo "0.1.3-SNAPSHOT"]
                 [clj-time "0.3.0-SNAPSHOT"]
                 [org.clojars.hozumi/mongodb-session "1.0.1"]]
  :dev-dependencies [[ring/ring-jetty-adapter "0.3.1"]                    
                     [swank-clojure "1.2.1"]
                     [ring/ring-devel "0.3.1"]
                     [lein-ring "0.2.4"]
                     [uk.org.alienscience/leiningen-war "0.0.8"]]
  ;; Used by leiningen-war to deploy static resources
  ;; :web-content "public"
  ;; The servlet used by Tomcat
  :aot [clj-rheo.servlet]
  :ring {:handler ryulogy.core/app})
