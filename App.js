import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import WelcomeScreen from './app/screens/WelcomeScreen';
import TrailListScreen from './app/screens/TrailListScreen';

export default function App() {
  const Stack = createNativeStackNavigator();

  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName='All'>
        <Stack.Screen name="Home" component={WelcomeScreen} />
        <Stack.Screen name="List" component={TrailListScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  )
}