import test from "node:test";
import assert from "node:assert/strict";
import { search, type SearchState } from "../src/search.js";

const state = (): SearchState => ({ loading: false, results: [], error: null });

test("latest query response wins", async () => {
  const s = state();
  let resolveOld!: (value: string[]) => void;
  const oldRequest = search("old", () => new Promise<string[]>(resolve => { resolveOld = resolve; }), s);
  await search("new", async () => ["new result"], s);
  resolveOld(["old result"]);
  await oldRequest;
  assert.deepEqual(s.results, ["new result"]);
});

test("request rejection clears loading and reports an error", async () => {
  const s = state();
  await assert.rejects(search("term", async () => { throw new Error("offline"); }, s));
  assert.equal(s.loading, false);
  assert.match(s.error ?? "", /offline/);
});
