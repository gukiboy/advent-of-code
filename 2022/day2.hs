module Examples where

import System.IO
import Control.Monad

-- X A Rock     1
-- Y B Paper    2
-- Z C Scissors 3
-- W 6
-- D 3
-- L 1

score :: String -> Integer
score "A X" = 3 + 1
score "B Y" = 3 + 2
score "C Z" = 3 + 3
score "A Y" = 6 + 2
score "B Z" = 6 + 3
score "C X" = 6 + 1
score "A Z" = 0 + 3
score "B X" = 0 + 1
score "C Y" = 0 + 2
score a = 0

actualScore :: String -> Integer
actualScore "A X" = 3 + 0
actualScore "A Y" = 1 + 3
actualScore "A Z" = 2 + 6
actualScore "B X" = 1 + 0
actualScore "B Y" = 2 + 3
actualScore "B Z" = 3 + 6
actualScore "C X" = 2 + 0
actualScore "C Y" = 3 + 3
actualScore "C Z" = 1 + 6
actualScore a = 0

totalScore :: String -> IO Integer
totalScore filePath = do fileContent <- readFile filePath
                         let linesOfFile = lines fileContent
                             folded = foldr (\ x y -> actualScore x + y) 0 linesOfFile
                         return folded
