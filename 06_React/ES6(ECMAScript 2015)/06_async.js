//기존 callback 함수
const getTest = (data, callback) => {
    console.log("서버로 값 전달 : ", data);
    setTimeout(() => {
        console.log("서버에서 응답 도착");
        callback("성공");
    }, 3000)
}

getTest({id: 30}, (result) => {
    console.log(result)
})

const getTest2 = (data) => {
    return new Promise((resolve, reject)=> {
        console.log("서버로 값 전달 : ", data);
    setTimeout(() => {
        console.log("서버에서 응답 도착");
        callback("성공");
    }, 3000)
})
}

getTest2({id: 20})
    .then(result => {
        console.log(result)
        return getTest2({id: 21});
    })
    .then(result => {
        console.log(result);
    })