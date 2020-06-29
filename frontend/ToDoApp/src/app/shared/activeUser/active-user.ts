export class ActiveUser {
    
    constructor(   
        public username:string,
        public id:number,
        public name:string,
        public lastname:string,
        public birthdate:Date,
        public emailstatus:boolean,
        public accstatus:boolean,
        public role:string,
        public lastactive:Date){}
}
