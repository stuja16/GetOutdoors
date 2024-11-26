import React from 'react';
import { StyleSheet, TextInput, View, Button } from 'react-native';

function SignInScreen({ navigation }) {
    state = {
        username: 'username',
        password: 'password'
    };

    _signInAsync = async () => {
        console.log(this.userName)
        console.log(this.Password)
        try {
            const response = await fetch('http://10.0.2.2:8085/users/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    username: this.userName,
                    password: this.Password,
                }),
            });
            
            if (!response.ok) {
                const errorData = await response.json();
                throw new Error(`Network response was not ok: ${response.status} - ${errorData.message}`);
            }
                        
            const data = await response.json();
            console.log('Login successful:', data);

            navigation.navigate('List')
        } catch (error) {
            console.error('Fetch error:', error.message);
        }
    };

    return (
        <View style={styles.background}>
            <View style={styles.container}>
                <TextInput
                    style={styles.textInput}
                    placeholder='username'
                    onChangeText={(text) => this.userName = text}
                    clearTextOnFocus={true}
                    maxLength={20}
                    returnKeyType={'next'}
                />
            </View>
            <View style={styles.container}>
                <TextInput
                    style={styles.textInput}
                    placeholder='password'
                    onChangeText={(text) => this.Password = text}
                    clearTextOnFocus={true}
                    maxLength={20}
                    returnKeyType={'next'}
                />
            </View>
            <Button
                style={styles.button}
                title="Sign in!" 
                onPress={this._signInAsync} 
            />
        </View>
    );
}

const styles = StyleSheet.create({
    background: {
        paddingTop: 20,
        paddingBottom: 20,

        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
      },
      container: {
        borderBottomColor: '#000',
        borderBottomWidth: 1,
        gap: 10,
      },
      textInput: {
        padding: 10,
      },
      button: {
        marginTop: 30,
      },
})

export default SignInScreen;