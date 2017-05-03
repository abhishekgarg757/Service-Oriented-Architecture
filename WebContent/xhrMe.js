class myXhr {
    get(body){
        // console.log(body.data);
        const xhr = new XMLHttpRequest();

        return new Promise(function(resolve,reject){
            (body.data == null) ? xhr.open("get", body.url , true): xhr.open("get", body.url + "?" + body.data , true) ;
            xhr.send();
            // console.log(body.data);
            xhr.onreadystatechange = function(){
                if (xhr.readyState == 4) {
                    if(xhr.status == 200){
                        resolve(xhr.response);
                    }else{
                        reject("error");
                    }
                }
            }
        });
    }

    getRegHed(a){
        let key = [];
        let val = [];

        for (let k in a){
            key.push(k);
            val.push(a[k]);
        }

        return ([key,val])
    }

    post(body){
        // console.log(body);
        const xhr = new XMLHttpRequest();
        let headers = this.getRegHed(body.headers);
        return new Promise(function(resolve,reject){
            xhr.open("post", body.url , true);
            for (let i in headers){
                (headers[0][i] == null) ? console.log("null one") :xhr.setRequestHeader(headers[0][i], headers[1][i]);
                // console.log(headers[0][i], headers[1][i]);
            }
            xhr.send(JSON.stringify(body.data));
            xhr.onreadystatechange = function(){
                if (xhr.readyState == 4) {
                    if(xhr.status == 200){
                        resolve(xhr.response);
                    }else{
                        reject("error");
                    }
                }
            }
        });
    }
}