// document.addEventListener('DOMContentLoaded', function(){
//
//     document.querySelector('form').onsubmit = function(){
//         fetch('http://api.exchangeratesapi.io/v1/latest?access_key=e237bb7d20eb066d0b335353e854dc02')
//             .then(response => response.json())
//             .then(data => {
//                 currency = document.querySelector('#input-one').value.toUpperCase();
//                 rate = data.rates[currency];
//                 if(rate !== undefined){
//                     document.querySelector('#result-one').innerHTML = `1 EUR equals to ${rate.toFixed(2)} ${currency}`;
//                 } else {
//                     document.querySelector('#result-one').innerHTML = 'Invalid Currency';
//                 }
//             })
//             .catch(error => {
//                 console.log(error);
//             });
//         return false;
//     }
// });