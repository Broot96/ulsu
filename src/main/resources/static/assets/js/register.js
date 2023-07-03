/*
* register.js
* */

function selectTeam(){



    const wrtTeamSelect = document.getElementById("wrtTeam");
    const writerName1 = document.getElementById("wrtName1");
    const writerName2 = document.getElementById("wrtName2");

    console.log(wrtTeamSelect.value)

    if (wrtTeamSelect.value === "뎁쑤좋다얼쑤") {
      writerName1.style.display = "block";
      writerName2.style.display = "none";
    }else if(wrtTeamSelect.value === "뎁스"){
        writerName2.style.display = "block";
        writerName1.style.display = "none";
    } else{
      writerName1.style.display = "none";
      writerName2.style.display = "none";
    }

}





