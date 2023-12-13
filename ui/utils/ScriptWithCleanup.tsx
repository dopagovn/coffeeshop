import { useEffect } from 'react';
import { useRouter } from 'next/router';
import Script, { ScriptProps } from 'next/script';

export const ScriptWithCleanup = (props: ScriptProps) => {
  const router = useRouter();

  useEffect(() => {
    // Needed for cleaning residue left by the external script
    // that can only be removed by reloading the page
    const onRouterChange = (newPath: string) => {
      window.location.href = router.basePath + newPath;
    };
    router.events.on('routeChangeStart', onRouterChange);

    return () => {
      router.events.off('routeChangeStart', onRouterChange);
    };
  }, [router, props]);

  return <Script {...props} />;
};