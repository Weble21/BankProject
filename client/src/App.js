import * as React from "react";

const googleClientId = "<TODO>";
const githubClientId = "<TODO>";

const serverCallbackUrl = "http://localhost:3000/api/v1/auth/callback";

const App: React.FC = () => {
  const loginWithGoogle = () => {
    const scope = "email profile";
    const authUrl = `https://accounts.google.com/o/oauth2/auth?client_id=${googleClientId}&redirect_uri=${encodeURIComponent(
      serverCallbackUrl
    )}&response_type=code&scope=${scope}&state=google`;

    window.location.href = authUrl;
  };
  const loginWithGitHub = () => {
    const scope = "user:email";
    const authUrl = `https://github.com/login/oauth/authorize?client_id=${githubClientId}&redirect_uri=${encodeURIComponent(
      serverCallbackUrl
    )}&scope=${scope}&state=github`;

    window.location.href = authUrl;
  };

  return (
    <div>
      <h2>OAuth2 로그인</h2>
      <button onClick={loginWithGoogle}>Google Login</button>
      <button onClick={loginWithGitHub}>GitHub Login</button>
    </div>
  );
};

export default App;
