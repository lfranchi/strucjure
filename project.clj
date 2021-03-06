(defproject strucjure "0.3.3"
  :description "Pattern-matching, parsing and generic traversals via PEGs"
  :url "http://github.com/jamii/strucjure"
  :license {:name "LGPL"
            :url "http://www.gnu.org/licenses/lgpl.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [slingshot "0.10.3"]
                 [org.clojure/core.cache "0.6.2"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.trace "0.7.3"]]}})
