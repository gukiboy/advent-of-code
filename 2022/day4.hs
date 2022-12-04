module Day4 where

import System.IO
import Control.Monad

wordsWhen     :: (Char -> Bool) -> String -> [String]
wordsWhen p s =  case dropWhile p s of
                      "" -> []
                      s' -> w : wordsWhen p s''
                            where (w, s'') = break p s'

isFullyContained :: [Integer] -> [Integer] -> Bool
isFullyContained a b = head a <= head b && a!!1 >= b!!1 || head a >= head b && a!!1 <= b!!1

isSomewhatContained :: [Integer] -> [Integer] -> Bool
isSomewhatContained a b = isFullyContained a b ||
                              a!!0 <= b!!1 && a!!1 >= b!!0 ||
                              b!!0 <= a!!1 && b!!1 >= a!!0

fullyContainedPairs :: String -> IO Integer
fullyContainedPairs filePath = do fileContent <- readFile filePath
                                  let linesOfFile = lines fileContent
                                      splitComma = map (wordsWhen (==',')) linesOfFile
                                      splitHyphen = map (\ a -> map (wordsWhen (=='-')) a) splitComma
                                      mapInt = map (\ a -> map (\ b -> map (\ c -> read c :: Integer) b) a) splitHyphen
                                      mapContained = map (\ a -> if (isSomewhatContained (a!!0) (a!!1)) then 1 else 0) mapInt
                                      reduced = sum mapContained
                                  return reduced

main = fullyContainedPairs "day4-input.txt"
