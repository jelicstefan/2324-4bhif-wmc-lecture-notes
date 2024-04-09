import {BehaviorSubject} from "rxjs";
import {Draft, produce} from "immer";

export interface Model {
  readonly name: string
  readonly email: string
}

const initialState: Model = {
  name: "Chris",
  email: "Doe"
}
export const store = new BehaviorSubject<Model>(initialState)

export function set(recipe: (model: Draft<Model>) => void){
  const nextModel = produce(store.getValue(), recipe)
  store.next(nextModel)
}
