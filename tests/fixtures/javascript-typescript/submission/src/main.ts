import { search, type SearchState } from "./search.js";

const form = document.querySelector<HTMLFormElement>("#searchForm")!;
const query = document.querySelector<HTMLInputElement>("#query")!;
const status = document.querySelector<HTMLElement>("#status")!;
const results = document.querySelector<HTMLUListElement>("#results")!;
const state: SearchState = { loading: false, results: [], error: null };

function render(): void {
  status.textContent = state.loading ? "Loading…" : state.error ?? (state.results.length ? "" : "No results");
  results.replaceChildren(...state.results.map(value => {
    const item = document.createElement("li");
    item.textContent = value;
    return item;
  }));
}

form.addEventListener("submit", async event => {
  event.preventDefault();
  const pending = search(query.value, async value => {
    const response = await fetch(`/search?q=${encodeURIComponent(value)}`);
    if (!response.ok) throw new Error(`Search failed (${response.status})`);
    return response.json() as Promise<string[]>;
  }, state);
  render();
  await pending;
  render();
});
