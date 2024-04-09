import {BehaviorSubject} from "rxjs";

export interface Model {
  readonly name: string
  readonly email: string
}
const initialState: Model = {
  name: "Chris",
  email: "Doe"
}
export const store = new BehaviorSubject<Model>(initialState)
