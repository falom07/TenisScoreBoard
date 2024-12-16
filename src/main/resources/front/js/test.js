function checkForm(el){
    console.log("hi1");
    let firstUser = el.player1.value;
    let errorUser = document.getElementById("usernameAnswer");
    let firstUser2 = el.player2.value;
    let errorUser2 = document.getElementById("usernameAnswer2");
    let isCorrect = true;


    if(firstUser === ""){
        errorUser.innerHTML = "User name can not be empty";
        errorUser.style.color = "red";
        isCorrect = false;
    }else if(firstUser.length < 3){
        errorUser.innerHTML = "User name can not be shoter than 3 symbol";
        errorUser.style.color = "red";
        isCorrect = false;
    }else if(firstUser.length > 20){
        errorUser.innerHTML = "User name can not be longer than 20 symbol";
        errorUser.style.color = "red";
        isCorrect = false;
    }else if(!isNaN(parseInt(firstUser.substring(0,1)))){
        errorUser.innerHTML = "User name can not begin from digital";
        errorUser.style.color = "red";
        isCorrect = false;
    }

    if(firstUser2 === ""){
        errorUser2.innerHTML = "User name can not be empty";
        errorUser2.style.color = "red";
        isCorrect = false;
    }else if (firstUser2.length < 3) {
        errorUser2.innerHTML = "User name can not be shoter than 3 symbol";
        errorUser2.style.color = "red";
        isCorrect = false;
    } else if (firstUser2.length > 20) {
        errorUser2.innerHTML = "User name can not be longer than 20 symbol";
        errorUser2.style.color = "red";
        isCorrect = false;
    } else if (!isNaN(parseInt(firstUser2.substring(0, 1)))) {
        errorUser2.innerHTML = "User name can not begin from digital";
        errorUser2.style.color = "red";
        isCorrect = false;
    }
    console.log("hi");



    return isCorrect;

}