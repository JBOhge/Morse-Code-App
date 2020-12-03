
var horizontal = 0;
var timerid = 0;
var increaseH = 10;//amount of increase of the movement in horz
var increaseV = 0; //amount of increase of movemnet in vertical
var vertical = 200;
var exist = 0;
var historyhorizontal = []; //array to record drawn height pixels
var historyvertical = []; //array to record drawn height pixels
var something =0

 function showAndroidToast(toast) {
            AndroidInterface.showToast(toast);
        }

//timer handeler fucntion 
function timer() {
if(vertical ==200 && horizontal ==0){
something=1;
}

  var context = document.getElementById("canvasId").getContext("2d");


  context.fillStyle = "#ffc82f";



  if (historyhorizontal.length == 0) {
    historyhorizontal.push(horizontal);
    historyvertical.push(vertical);
  }
  else {//checking if we have drawn a canvas on this spot or not? 
    for (var i = 0; i < historyhorizontal.length; i++) {
      if (horizontal == historyhorizontal[i] && vertical == historyvertical[i]) {
        clearInterval(timerid);
        exist = 1;
      }
    }
  }

  if (exist != 1) { //if it does not exist only then can we draw
    historyhorizontal.push(horizontal);
    historyvertical.push(vertical);
    context.rect(horizontal, vertical, 10, 10);
  }else{
 showAndroidToast('You Lose');
  }

if(vertical== 400 ||vertical==0||horizontal==400 ||horizontal==0){
if(something!=1){
showAndroidToast('You Lose');

}else{
something=0;}

}




  context.rect(horizontal, vertical, 10, 10);
  vertical = vertical - increaseV;
  horizontal = horizontal + increaseH;

  // context.fillStyle = "#ffffffff";

  //fill the rectangle
  context.fill();
}



//handler function for start/stop button
function switchbtn() {
 



  if (document.getElementById("btn_switch").value == "Start" && exist != 1) {
    timerid = setInterval(timer, 1000);
    document.getElementById("btn_switch").value = "stop";

  }
  else if (document.getElementById("btn_switch").value == "stop") {
    clearInterval(timerid);
    document.getElementById("btn_switch").value = "Start";
  }



}

//handler function for left button
function leftbtn() {
  var context = document.getElementById("canvasId").getContext("2d");

  context.rect(horizontal, vertical, 10, 10);


  if (increaseH == 0 && increaseV != -10) {
    increaseH = -10;
    increaseV = 0;
  } else if (increaseH == -10) {
    increaseH = 0;
    increaseV = -10;
  } else if (increaseV == -10) {
    increaseH = 10;
    increaseV = 0;
  } else {
    increaseH = 0;
    increaseV = 10;
  }


}

//handler function for right button 
function rightbtn() {
  var context = document.getElementById("canvasId").getContext("2d");

  context.rect(horizontal, vertical, 10, 10);

  if (increaseH == 0 && increaseV != 10) {
    increaseH = -10;
    increaseV = 0;
  } else if (increaseH == 10) {
    increaseH = 0;
    increaseV = -10;
  } else if (increaseV == 10) {
    increaseH = 10;
    increaseV = 0;
  } else {
    increaseH = 0;
    increaseV = 10;
  }

}
