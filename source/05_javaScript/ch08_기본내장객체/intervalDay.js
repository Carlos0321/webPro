// JavaScript source code(intervalDay.js)
Date.prototype.intervalDay = function (that) {
    if (this > that) { //limitday�� this��  intervalDay(now)�� now�� that����
        intervalMil = this.getTime() - that.getTime();
    } else {
        intervalMil = that.getTime() - this.getTime();
    }
    var day = intervalMil / (1000 * 60 * 60 * 24);
    return Math.trunc(day);
};
