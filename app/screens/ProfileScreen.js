import React from "react";
import {
  StyleSheet,
  Text,
  View,
  ImageBackground,
  Dimensions,
  ScrollView,
  TouchableOpacity,
} from "react-native";
import { LinearGradient } from "expo-linear-gradient";
import { Icon } from "@rneui/themed";
import { useNavigation } from '@react-navigation/native';

import colors from "../config/colors";

const w = Dimensions.get("window").width;
const h = Dimensions.get("window").height;

function ProfileScreen() {
  const navigation = useNavigation();

  return (
    <ScrollView style={styles.background}>
      <ImageBackground
        source={require("../assets/blank-profile-image.png")}
        style={{
          height: h * 0.45,
        }}
      >
        <View
          style={{
            flexDirection: "row",
            justifyContent: "space-between",
            paddingHorizontal: 20,
            marginTop: 60,
            alignItems: "center",
          }}
        >
          <TouchableOpacity onPress={() => onPressEdit()}>
            <Icon
              name="edit-note"
              underlayColor="transparent"
              iconStyle={styles.emailIcon}
            />
          </TouchableOpacity>
          <TouchableOpacity
            onPress={() => navigation.navigate("Settings")}
          >
            <Icon
              name="settings"
              underlayColor="transparent"
              iconStyle={styles.emailIcon}
            />
          </TouchableOpacity>
        </View>
        <LinearGradient
          colors={["rgba(36,19,50,1)", "transparent"]}
          style={{
            transform: [{ rotate: "180deg" }],
            position: "absolute",
            left: 0,
            right: 0,
            bottom: 0,
            zIndex: 1,
            height: 0.16 * h,
          }}
        >
          <Text
            style={{
              transform: [{ rotate: "-180deg" }],
              color: "#FFF",
              fontSize: 35,
              marginVertical: 30,
              alignSelf: "center",
            }}
          >
            Test User
          </Text>
        </LinearGradient>
      </ImageBackground>
      <View
        style={{
          flexDirection: "row",
          alignItems: "center",
          justifyContent: "space-between",
          paddingHorizontal: 10,
          paddingVertical: 20,
        }}
      >
        <View style={styles.iconRow}>
          {
            <Icon
              name="email"
              underlayColor="transparent"
              iconStyle={styles.emailIcon}
            />
          }
        </View>
        <View style={styles.emailRow}>
          <Text style={styles.emailText}>test.user@host.com</Text>
        </View>
      </View>
    </ScrollView>
  );
}

onPressEdit = () => {
  console.log("Placeholder for edit screen");
};

const styles = StyleSheet.create({
  background: {
    backgroundColor: "#FFFFFF",
  },
  iconRow: {
    flex: 2,
    justifyContent: "center",
  },
  emailIcon: {
    color: colors.secondary,
    fontSize: 50,
  },
  emailRow: {
    flex: 8,
    flexDirection: "column",
    justifyContent: "center",
  },
  emailText: {
    fontSize: 20,
  },
});

export default ProfileScreen;
