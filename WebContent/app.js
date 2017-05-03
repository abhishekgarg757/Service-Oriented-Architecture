const xhr = new myXhr();

function $(x){
    return document.getElementById(x).value;
}
function ob(x){
    return document.getElementById(x);
}

const but = document.getElementById("happy");

but.addEventListener('click',function(){
    xhr.get({
    url:"http://localhost:8080/Acomponentes/dispatcher",
    data:`cName=${$("cname")}&mName=${$("mname")}&params=[${$("params")}]&ptypes=[${$("ptypes")}]`
    }).then(function(dta){
        console.log(dta);
        let data = JSON.parse(dta);
        ob("response2").innerHTML=data["return"]||data["exception"];
    },function(err){
        console.log(err);
    });
});