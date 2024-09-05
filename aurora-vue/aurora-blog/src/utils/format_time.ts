const formatTime = (data: any): string => {
    let hours = timeStyle(new Date(data).getHours())
    let minutes = timeStyle(new Date(data).getMinutes())
    let seconds = timeStyle(new Date(data).getSeconds())
    return hours + ':' + minutes + ':' + seconds
  }
  const timeStyle = (number: any): string=>{
    if(number < 10){
        return `0${number}`
    }
    return number    
  }

export default formatTime