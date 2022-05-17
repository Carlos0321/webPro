// JavaScript source code(intervalDay.js)
Date.prototype.intervalDay = function (that) {
    if (this > that) { //limitday가 this로  intervalDay(now)의 now가 that으로
        intervalMil = this.getTime() - that.getTime();
    } else {
        intervalMil = that.getTime() - this.getTime();
    }
    var day = intervalMil / (1000 * 60 * 60 * 24);
    return Math.trunc(day);
};
