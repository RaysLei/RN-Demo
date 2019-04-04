/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 * @lint-ignore-every XPLATJSCOPYRIGHT1
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View,DeviceEventEmitter,NativeModules} from 'react-native';

let message = "dxw"

DeviceEventEmitter.addListener('NewRNLayout',(msg)=>{ 
  title = "React Native界面,收到数据：" + msg; 
  message = msg; 
  //ToastAndroid.show("发送成功", ToastAndroid.SHORT); 
})

export default class NewRNLayout extends Component { 
  constructor(props) { 
    super(props); 
  } 
  render() { 
    return ( 
      <View style={styles.container}> 
        <Text>NewRNLayout</Text>
      </View> 
    ); 
  } 
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
});
