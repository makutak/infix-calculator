# infix-calculator
[![CircleCI](https://circleci.com/gh/makutak/infix-calculator.svg?style=svg)](https://circleci.com/gh/makutak/infix-calculator)

A Clojure infix calculator.

## Usage

```clojure
(infix '(1 + 1))
=> 2

(infix '(1 + 3 * 4 - 5))
=> 8

(infix '(1 + 3 * (4 - 5)))
=> -2
```

## License

Copyright © 2018 tkouno

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
