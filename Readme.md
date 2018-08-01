# React Native PBKDF2
> A Password Based Key Derivation 2 (PBKDF2) algorithm for React Native

[![MIT License](https://img.shields.io/badge/License-MIT-brightgreen.svg)](https://tldrlegal.com/license/mit-license)

PBKDF2 (Password-Based Key Derivation Function 2) are key derivation functions with a sliding computational cost, aimed to reduce the vulnerability of encrypted keys to brute force attacks.

PBKDF2 applies a pseudorandom function, such as hash-based message authentication code (HMAC), to the input password or passphrase along with a salt value and repeats the process many times to produce a derived key, which can then be used as a cryptographic key in subsequent operations. The added computational work makes password cracking much more difficult, and is known as key stretching.

## Motivation
The motivation for create this _lib_ is to make a isolated and native way to use PBKDF2 algorithm in React Native. Because it's more simple to usage and maintain. The existent _libs_ today or are not using native code or don't keep a semantic, isolated and clean usage.

The _lib_ [PublicaIO/react-native-pbkdf2](https://github.com/PublicaIO/react-native-pbkdf2), for example, not use the native code and the [react-native-aes](https://github.com/tectiv3/react-native-aes) contain some other methods

> This _lib_ is totally based on [react-native-aes](https://github.com/tectiv3/react-native-aes), but with some improvements like `iteration` param suppport.

## Getting started

`$ yarn add https://github.com/quan-to/react-native-pbkdf2`

### Linking

`$ react-native link react-native-pbkdf2`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-pbkdf2` and add `RNPBKDF2.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRCTPBKDF2.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import rnpbkdf2.PBKDF2Package;` to the imports at the top of the file
  - Add `new PBKDF2Package()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-pbkdf2'
  	project(':react-native-pbkdf2').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-pbkdf2/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-pbkdf2')
  	```


## Usage
```javascript
import PBKDF2 from 'react-native-pbkdf2'

PBKDF2.derivationKey('P4S5W0RD', '032145', 10000)
  .then((derivationKey) => console.log(derivationKey))
  .catch(...)
```
