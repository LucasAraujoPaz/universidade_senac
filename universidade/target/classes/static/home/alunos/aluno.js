/**
 * @typedef {{
 * id: number,
 * cpf: number,
 * nome: string,
 * dataDeNascimento: Date,
 * email: string,
 * telefone: number,
 * status: number | string
 * }} IAluno
 */

/** 
 * @implements {IAluno}
 * @implements {IEntidadeComId}
 */
class Aluno {

    /** @param {IAluno} aluno */
    constructor({id, cpf, nome, dataDeNascimento, email, telefone, status}) {
            this.id = sanitizarId(id);
            this.cpf = cpf;
            this.nome = nome;
            this.dataDeNascimento = sanitizarData(dataDeNascimento);
            this.email = email;
            this.telefone = telefone;
            this.status = status;
    }
}

/** @type {ICRUD<Aluno>} */
Aluno.CRUD = {
    
    URL: Internet.URLS.URL_ALUNOS,

    async listar() {
        /** @type {IAluno[]} */
        const alunos = await Internet.getJson(this.URL)
        return alunos.map(aluno => new Aluno(aluno));
    },
    async obter(id) {
        /** @type {IAluno} */
        const aluno = await Internet.getJson(this.URL + "/" + id);
        return new Aluno(aluno);
    },
    async criar(aluno) {
        return await Internet.post(this.URL, aluno);
    },
    async editar(aluno) {
        return await Internet.put(this.URL, aluno);
    },
    async deletar(id) {
        await Internet.delete(this.URL + "/" + id);
    }
}

/** @type {IFormulario<Aluno>} */
Aluno.Formulario = {

    nomeDoLink: "linkAlunos",
    nomeDoFormulario: "aluno",

    async preencher(aluno) {
    
        await renderizarCorpo("alunos/aluno.html");

        Formulario.preencher(Aluno, aluno);

        /** @type {HTMLInputElement} */
        const dataDeNascimento = (document.forms
            .namedItem(this.nomeDoFormulario)?.elements
            .namedItem("dataDeNascimento"));

        if (! (dataDeNascimento && aluno) ) 
            return;

        dataDeNascimento.value = 
            aluno.dataDeNascimento.toLocaleDateString("en-CA");
    },

    obter() {

        const form = document.forms.namedItem(this.nomeDoFormulario);
        if (!form)
            throw new Error("Erro no formulário.");
        const fd = new FormData(form);

        const aluno = new Aluno({
            id: sanitizarId(fd.get("id")),
            cpf: Number(fd.get("cpf")),
            nome: String(fd.get("nome")),
            dataDeNascimento: new Date(String(fd.get("dataDeNascimento"))),
            email: String(fd.get("email")),
            telefone: Number(fd.get("telefone")),
            status: Number(fd.get("status")) ?? 0
        });
        
        return aluno;
    }
}