import { Teacher } from "./Teacher";
export class Course {
    courseId:number;
    courseName:string;
    description:string;
    teacher:Teacher;
    constructor(courseId:number,courseName:string,teacher:Teacher,description:string){
        this.courseId=courseId;
        this.courseName=courseName;
        this.description=description;
        this.teacher=teacher;
    }
    // logAttributes():void{
    //     console.log("courseId:",this.courseId);
    //     console.log("courseName:",this.courseName);
    //     console.log("teacher:",this.teacher);
    //     console.log("description:",this.description);
        
    // }

}