(ns infix-calculator.core-test
  (:require [clojure.test :refer :all]
            [infix-calculator.core :refer :all]))

(deftest infix-test
  (testing "calculate infix"
    (is (= 8
           (int (infix '(1 + 3 * 4 - 5)))))
    (is (= 85
           (int (infix '(38 + 48 - 2 / 2)))))
    (is (= -29
           (int (infix '(1 * 3 - 8 * 4)))))
    (is (= 15
           (int (infix '(1 - 2 * 3 + 4 * 5 ))))))
  (testing "calculate nested infix"
    (is (= -2
           (int (infix '(1 + 3 * (4 - 5))))))))
