export const NotifyTypes = Object.freeze({
    SUCCESS: 'success',
    ERROR: 'error',
    WARNING: 'warning',
    INFO: 'info',
});

export default (modalType: any, { title, message, messages }: any) => {
    let content = message;
    if (!!messages && messages.length > 0) {
        content = (
            <div>
                {messages.map((x: any, i: any) => (
                    <p key={i}>{x}</p>
                ))}
            </div>
        );
    }
};
