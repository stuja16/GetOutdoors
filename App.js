import { StatusBar } from "expo-status-bar";
import { NavigationContainer } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { SafeAreaProvider } from "react-native-safe-area-context";
import { Ionicons } from "@expo/vector-icons";
import MaterialCommunityIcons from "@expo/vector-icons/MaterialCommunityIcons";

import SignInScreen from "./app/screens/Authentication/SignInScreen";

import WelcomeScreen from "./app/screens/WelcomeScreen";
import TrailListScreen from "./app/screens/TrailListScreen";
import TrailInfoScreen from "./app/screens/TrailInfoScreen";
import ProfileScreen from "./app/screens/ProfileScreen";
import SettingsScreen from "./app/screens/SettingsScreen";

const Tab = createBottomTabNavigator();
const SearchStack = createNativeStackNavigator();
const ProfileStack = createNativeStackNavigator();

function SearchStackScreen() {
  return (
    <SearchStack.Navigator>
      <SearchStack.Screen name="Home" component={WelcomeScreen} />
      <SearchStack.Screen name="SignIn" component={SignInScreen} />
      <SearchStack.Screen
        name="List"
        component={TrailListScreen}
        options={{ title: "Nearby Trails" }}
      />
      <SearchStack.Screen name="Info" component={TrailInfoScreen} />
    </SearchStack.Navigator>
  );
}

function ProfileStackScreen() {
  return (
    <ProfileStack.Navigator
      screenOptions={{
        headerShown: false,
      }}
    >
      <ProfileStack.Screen name="User Details" component={ProfileScreen} />
      <ProfileStack.Screen name="Settings" component={SettingsScreen} />
    </ProfileStack.Navigator>
  );
}

export default function App() {
  return (
    <SafeAreaProvider>
      <NavigationContainer>
        <Tab.Navigator
          screenOptions={{
            headerShown: false,
            tabBarLabelStyle: {
              fontSize: 16,
            },
          }}
        >
          <Tab.Screen
            name="Search"
            component={SearchStackScreen}
            options={{
              tabBarIcon: ({ color, size }) => (
                <MaterialCommunityIcons
                  name="map-search-outline"
                  size={size}
                  color={color}
                />
              ),
            }}
          />
          <Tab.Screen
            name="Profile"
            component={ProfileStackScreen}
            options={{
              tabBarIcon: ({ color, size }) => (
                <Ionicons name="person-outline" size={size} color={color} />
              ),
            }}
          />
        </Tab.Navigator>
      </NavigationContainer>
    </SafeAreaProvider>
  );
}
