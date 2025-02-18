# Get Outdoors Mobile App

This is my senior project for my B.A. in Computer Science.

The Get Outdoors is a full-stack mobile application. It is very similar to AllTrails or other trail finders, and is compatible with both Android and IOS.

## Built With

- **React Native**
- **Spring Boot**
- **MySQL**
- **VSCode**
- **Android Studio**

## Installation & Usage

I have no plans to deploy this application to production, so using it is only recommended in a testing environment. It is not available in any app stores.

For full functionality, you must run the frontend application and the server separately and properly setup their connection. I have not tested running them on different machines, only locally on the same device.

## Launching the Application
Here are instructions for running the application in a devopment environment. Again, this is ***not recommended.*** I've included it mainly for myself for ease of use in the future.

#### Frontend:
1. Open the whole project locally.
2. Open Android Studio and launch an AVD to run the application on.
3. Run *one* of the following commands in the terminal:
    i. `npm start`
    ii. `expo start`
4. Once Metro Bundler launches from the terminal, press `a` to open the application on Android.
5. When done, press `Ctrl+C` to close the Metro Bundler.

More detailed instructions can be found [here.](https://reactnative.dev/docs/running-on-device)