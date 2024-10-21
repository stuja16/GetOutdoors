import React from 'react';
import {FlatList, StyleSheet, Text, View, TouchableWithoutFeedback} from 'react-native';
import { useNavigation } from '@react-navigation/native';

const TrailList = () => {
  const navigation = useNavigation();

  return (
    <View style={styles.container}>
      <FlatList
        data={[
          {key: 'Newberry Trail'},
          {key: 'Hydroelectric Heritage Trailway'},
          {key: 'Telulah Park'},
          {key: 'Ellen Kort Peace Park'},
        ]}
        renderItem={({item}) => (  
            <TouchableWithoutFeedback onPress={ () => {navigation.navigate('Info', {
              trailName: item.key,
            })}}>
              <Text style={styles.item}>{item.key}</Text>
            </TouchableWithoutFeedback>
        )}
      />
    </View>
  );
};

/*actionOnRow(item) {
  const navigation = useNavigation();
  console.log('Selected Item :',item.key);
  navigation.navigate('Info');
};*/

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 22,
  },
  item: {
    padding: 10,
    fontSize: 18,
    height: 44,
  },
});

export default TrailList;