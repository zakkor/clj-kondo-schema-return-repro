(ns clj-kondo-schema-return-repro.core
  (:require [malli.dev :as dev]))

(dev/start!)

;; This function spec states it takes a string and returns an int,
;; but it returns the same input param it was given, which should be an error.
(defn returns-string
  {:malli/schema [:=> [:cat :string] :int]}
  [x]
  x)

;; Error correctly reported when calling function with a non-string:
(returns-string 1)

;; No error reported when calling function with a string,
;; which means it returns a string instead of an int:
(returns-string "asd")