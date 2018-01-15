# fc-interview

Funding Circle coding challenge

## Usage

To run:

    $ lein run

## Options

No options are accepted.

### Notes

- Consider complexity.
- How fast does your code run?

  This code takes about 20 seconds to run on my laptop, but the
  majority of the time spent is due to JVM/Clojure startup.

- How does it scale?

  There is a nested `reduce`, which will scale poorly for larger
  tables (in hundreds or greater) due not to duplication of
  multiplication operations, but for inefficient string operations.

- Consider cases where we want N primes.

  When N primes are desired, change the argument passed to `primes`.

## License

Copyright © 2018 Matthew Batema

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
