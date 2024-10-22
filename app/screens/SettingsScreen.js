import React from 'react';

function SettingsScreen(props) {
    return (
        <View style={styles.background}>
            <Text>Settings</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    background: {
        paddingTop: 20,
        paddingBottom: 20,

        flex: 1,
        justifyContent: 'space-between',
        alignItems: 'center',
      },
})


export default SettingsScreen;