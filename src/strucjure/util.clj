(ns strucjure.util
  (:require clojure.set))

;; in user code in guards the input is bound to %
(def input-sym '%)

(defn symbols [form]
  (cond
   (symbol? form) #{form}
   (instance? clojure.lang.Seqable form) (apply clojure.set/union (map symbols form))
   :else #{}))

(defn src-with-scope [src scope]
  (let [used (symbols src)
        bindings-sym (gensym "bindings")
        bindings (for [symbol scope
                       :when (contains? used symbol)]
                   [symbol `(get ~bindings-sym '~symbol)])]
    `(vary-meta
      (fn [~input-sym ~bindings-sym]
        (let [~@(apply concat bindings)]
          ~src))
      assoc ~::src '~src)))

(defn with-*ns* [sym]
  (symbol (str *ns* "/" sym)))

(defn null-pre-view [name input]
  input)

(defn null-post-view [name output]
  output)
