# CTCI Solutions

Personal solutions to "Cracking the Coding Interview" problems in Java.

## Structure

```
├── solutions/
│   ├── TestUtils.java                    # Testing utility
│   └── 1-arrays_and_strings/
│       ├── IsUnique.java                 # 1.1 - Unique characters
│       ├── CheckPermutation.java         # 1.2 - String permutation
│       ├── ParlindromePermutation.java   # 1.4 - Palindrome permutation
│       ├── OneEditAway.java              # 1.5 - One edit away
│       └── StringCompression.java        # 1.6 - String compression
├── run.sh                                # Run script
└── README.md
```

## Usage

### Run any solution:
```bash
./run.sh solutions/1-arrays_and_strings/IsUnique.java
./run.sh solutions/1-arrays_and_strings/CheckPermutation.java
./run.sh solutions/1-arrays_and_strings/StringCompression.java
```

### Available solutions:
- **IsUnique** - Check if string has all unique characters
- **CheckPermutation** - Determine if one string is permutation of another
- **ParlindromePermutation** - Check if string is permutation of palindrome
- **OneEditAway** - Check if strings are one edit away
- **StringCompression** - Compress string using character counts

## Features

- **Consistent testing** with TestUtils utility
- **Minimal documentation** for personal learning
- **Comprehensive test cases** with pass/fail indicators
- **Easy execution** with run script
