(ns infix-calculator.core
  (:require [infix-calculator.calc :refer [parse]]))

(defn infix
  [infixed]
  (parse infixed))
