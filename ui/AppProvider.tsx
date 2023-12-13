import React, { createContext, useContext, ReactNode } from 'react';

interface AppContextProps {
    pathName: string;
}

const AppContext = createContext<AppContextProps | undefined>(undefined);

export const AppProvider: React.FC<{ children: ReactNode; pathName: string }> = ({ children, pathName }) => (
    <AppContext.Provider value={{ pathName }}>{children}</AppContext.Provider>
);

export const useAppContext = () => {
    const context = useContext(AppContext);
    if (!context) {
        throw new Error('useAppContext must be used within an AppProvider');
    }
    return context;
};
