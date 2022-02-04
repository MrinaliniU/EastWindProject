# Notes On Strings And Arrays

#### String split regex
1. **"\\\P{Alpha}+"** - split by any character other than alphabets.
2. **"\\\\."** - Regex to split at ".", try to use the escape char *"\\\\\"*

#### Way to store 26 lower case alphabets in a char array

Below code counts the number of occurrence of each char in string **s** and stores the count in the int[] array called **map**.
For capital letters use 65 instead of 97.
```$xslt
int[] map = new int[26];
for(int i = 0; i < s.length(); i++) map[s.charAt(i) - 'a']++;
```