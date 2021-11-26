/** 
 * @typedef {{
 * id: number
 * }} IEntidadeComId
 * */

/**
 * @template T
 * @typedef {{
 * readonly URL: string,
 * listar: () => Promise<T[]>,
 * obter: (id: number) => Promise<T>,
 * criar: (objeto: T) => Promise<T>,
 * editar: (objeto: T) => Promise<T>,
 * deletar: (id: number) => void
 * }} ICRUD<T>
 */

/** 
 * @typedef {{
 * [indexer: PropertyKey]: any
 * }} implements
 * */

/**
 * @template T
 * @typedef {implements & {
 * CRUD: ICRUD<T>, 
 * Formulario: IFormulario<T>
 * }} IFormularioCRUD<T>
 * */