import React from 'react';
import { StyleSheet, Text, TouchableWithoutFeedback } from 'react-native';
import { useNavigation } from '@react-navigation/native';

const TrailListItem = ({item}) => {
    const navigation = useNavigation();
    
    return (
        <TouchableWithoutFeedback onPress={ () => {navigation.navigate('Info', {
            trailName: item.key,
        })}}>
            <Text style={styles.item}>{item.key}</Text>
        </TouchableWithoutFeedback>
    );
}

const styles = StyleSheet.create({
    item: {
        padding: 10,
        fontSize: 18,
        height: 44,
    },
});

export default TrailListItem;