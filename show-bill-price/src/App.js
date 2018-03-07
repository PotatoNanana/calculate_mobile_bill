import React, { Component } from 'react';
import promotion1 from './promotion1.json';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">SHOW TOTAL AMOUNT DUE</h1>
        </header>
        <p className="App-intro">
          Create by <code>Napat Jintanakosol</code>.
        </p>
        <ul>
        {
          promotion1.map(function(bill){
            return <li>{bill.phone} - {bill.total}</li>;
          })
        }
        </ul>
      </div>
    );
  }
}

export default App;
