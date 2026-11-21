export type SearchState = {
  loading: boolean;
  results: string[];
  error: string | null;
};

export type SearchRequest = (query: string) => Promise<string[]>;

export async function search(query: string, request: SearchRequest, state: SearchState): Promise<void> {
  if (!query.trim()) {
    state.error = "Enter a search term";
    return;
  }
  state.loading = true;
  state.error = null;
  const results = await request(query);
  state.results = results;
  state.loading = false;
}
