# MC-118470

An external hotfix for the [MC-118470](https://bugs.mojang.com/browse/MC-118470) issue.

To sum it up, MC-118470 prevents the player from adjusting the volume of the narrator, an
accessibility-focused, text-to-speech voice that narrates the player's actions.
The narrator is mostly implemented through native access, a.k.a. it exists as part of the
operating system, and each operating system has its own narrator.

**Disclaimer: This mod is client-side only and won't do anything
in a dedicated server environment.**

## Platform Support

While this mod is functional and stable on Windows,
macOS and Linux (Flite) lack any attempt at an implementation.

Please submit a pull request if you'd like to see support for these platforms.