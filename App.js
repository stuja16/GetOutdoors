import { StatusBar } from 'expo-status-bar';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import WelcomeScreen from './app/screens/WelcomeScreen';
import TrailListScreen from './app/screens/TrailListScreen';
import TrailInfoScreen from './app/screens/TrailInfoScreen';

export default function App() {
  const Stack = createNativeStackNavigator();

  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName='All'>
        <Stack.Screen name="Home" component={WelcomeScreen} />
        <Stack.Screen name="List" component={TrailListScreen} options={{ title: 'Nearby Trails' }} />
        <Stack.Screen name="Info" component={TrailInfoScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  )
}