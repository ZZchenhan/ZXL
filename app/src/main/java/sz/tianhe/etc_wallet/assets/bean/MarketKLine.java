package sz.tianhe.etc_wallet.assets.bean;

import java.util.List;

public class MarketKLine {

    /**
     * symbol : btc
     * data : [[1532049300000,7411.86,7444,7398.59,7430.62,93.7615],[1532050200000,7431.38,7456.64,7417.74,7437.44,120.5053],[1532051100000,7437.19,7464.56,7435.15,7457.19,129.8524],[1532052000000,7459.31,7477.68,7442.87,7468.46,120.0653],[1532052900000,7466.04,7474.79,7437.07,7451.98,157.4844],[1532053800000,7453.58,7469.69,7444.09,7463.2,166.6099],[1532054700000,7462.83,7468.54,7448.64,7461.46,104.2935],[1532055600000,7461.53,7466.97,7455.12,7455.57,155.7785],[1532056500000,7455.18,7474.86,7431.57,7440.03,132.0233],[1532057400000,7441.33,7474.96,7438.7,7461.89,68.7341],[1532058300000,7463.31,7465.92,7454.4,7462.98,100.2536],[1532059200000,7465.62,7465.67,7441.07,7453.74,120.8342],[1532060100000,7455.56,7465.67,7436.42,7449.85,129.3144],[1532061000000,7450.95,7458.29,7447.22,7455.41,143.6561],[1532061960000,7455.54,7469.74,7455.54,7467.81,118.3867],[1532062800000,7458.43,7467.81,7446.65,7461.72,134.5301],[1532063700000,7461.24,7466.63,7441.13,7461.21,135.0113],[1532064600000,7461.36,7462.73,7418.08,7434.97,81.8334],[1532065500000,7434.88,7439.38,7418.72,7433.74,98.9676],[1532066400000,7428.5,7433.73,7400.65,7428.83,94.5863],[1532067300000,7428.99,7435.71,7414.79,7423.47,92.1158],[1532068200000,7422.63,7429.91,7369.93,7388.95,159.28],[1532069100000,7392.26,7393.54,7350.44,7373.4,128.5099],[1532070000000,7373.87,7380.95,7350,7377.17,118.9071],[1532070900000,7376.17,7393.37,7375.19,7393.37,63.9913],[1532071800000,7391.54,7415.4,7390.76,7408.03,92.9565],[1532072700000,7409.01,7442.54,7406.38,7442.45,61.6088],[1532073600000,7444.77,7497.98,7427.51,7462.04,135.9097],[1532074500000,7462.98,7513.06,7457.76,7462.56,146.8511],[1532075400000,7459.75,7475.2,7448.59,7455.24,129.9982],[1532076300000,7452.43,7474.23,7441,7472.45,127.8597],[1532077200000,7473.69,7488.88,7454.62,7469.72,110.402],[1532078160000,7463.6,7485.59,7452.67,7484.29,82.3777],[1532079000000,7479.13,7483.24,7451.15,7451.16,87.2771],[1532079900000,7451.35,7458.71,7449.82,7450.14,103.3951],[1532080800000,7450.16,7468.62,7447.62,7457.8,141.5648],[1532081700000,7457.79,7473.08,7452.01,7459.81,101.7158],[1532082600000,7460.88,7469.91,7451.99,7469.41,145.9049],[1532083500000,7469.32,7477.95,7458.9,7472.2,146.6681],[1532084400000,7468.27,7479.61,7463.1,7477.27,154.6933],[1532085300000,7477.34,7491.3,7463.15,7481,150.1583],[1532086200000,7479.73,7488.62,7470.09,7481.75,130.6487],[1532087100000,7487.07,7511.89,7479.3,7496.82,123.0385],[1532088000000,7502.81,7514.52,7467.66,7475.99,77.9092],[1532088900000,7476.86,7489.85,7464.07,7465.55,147.6292],[1532089800000,7464.4,7471.49,7450.3,7456.63,125.0584],[1532090700000,7452.14,7477.9,7452.14,7475.34,100.7457],[1532091600000,7476.46,7483.65,7458.87,7472.2,118.4666],[1532092500000,7476.77,7479.89,7450.35,7457.56,119.5229],[1532093400000,7451.47,7467.83,7447.26,7465.14,83.9373],[1532094300000,7469.66,7486.31,7469.66,7479.94,25.5451],[1532095200000,7481.17,7485.26,7447.14,7468.74,118.5519],[1532096100000,7466.04,7500.06,7457.73,7473.26,109.7819],[1532097000000,7469.98,7493.04,7469.98,7484.9,138.688],[1532097900000,7485.64,7491.91,7461.32,7484.47,131.1318],[1532098800000,7484.46,7500.87,7479.02,7497.92,102.7721],[1532099700000,7500.7,7522.15,7469.25,7473.86,150.4053],[1532100600000,7475.94,7479.5,7455.07,7472,150.5208],[1532101500000,7473.06,7486.83,7465.72,7476.31,85.5471],[1532102400000,7478.62,7497.95,7472.96,7494.39,371.2251],[1532103300000,7494.73,7509.71,7481.75,7491.18,593.8458],[1532104200000,7503.09,7680,7488.55,7604.67,853.578],[1532105100000,7603.78,7633.45,7475.68,7479.63,729.4985],[1532106000000,7478.6,7505.31,7367.65,7393.79,868.578],[1532106900000,7395.51,7425.24,7350,7383.56,173.621],[1532107800000,7387.34,7416.92,7369.83,7401.14,463.3163],[1532108700000,7401.67,7402.19,7310,7339.39,212.8989],[1532109600000,7340.59,7388.07,7292.82,7364.63,389.3401],[1532110500000,7364.57,7388.05,7317.41,7333.88,585.2738],[1532111400000,7331.98,7387.87,7329.49,7360.77,473.366],[1532112300000,7364.6,7367.84,7336.68,7365.84,615.4166],[1532113200000,7365.27,7366.5,7341.93,7364.48,1166.9941],[1532114100000,7364.37,7402.48,7345.86,7345.86,85.018],[1532115000000,7351.07,7368.1,7309.02,7338.3,136.0235],[1532115900000,7338.28,7368.01,7337.64,7362.23,123.5525],[1532116800000,7362.3,7368.15,7342.97,7356.7,110.9027],[1532117700000,7357.49,7367.2,7351.27,7355.5,84.5895],[1532118600000,7358.92,7367.41,7344.11,7358.69,61.8008],[1532119500000,7364.08,7368.16,7345.92,7356.2,99.7568],[1532120400000,7356.21,7358.79,7349.33,7357.02,71.2675],[1532121300000,7353.85,7370.61,7344.12,7367.98,118.7713],[1532122200000,7366.21,7370.59,7358.26,7367.44,95.6782],[1532123100000,7367.35,7367.78,7308.35,7313.85,135.7561],[1532124000000,7314.33,7339.77,7288.95,7302.65,104.8555],[1532124900000,7310.01,7333.11,7287.48,7331.48,43.1924],[1532125800000,7333.44,7377.76,7326.03,7341.37,93.1324],[1532126700000,7335.33,7364.64,7331.61,7364.64,81.9278],[1532127600000,7364.72,7368.33,7341.41,7341.43,126.8248],[1532128500000,7341.41,7341.45,7326.05,7338.08,133.1809],[1532129400000,7340.66,7347.23,7320.92,7333.97,106.8981],[1532130300000,7331.39,7342.12,7324.02,7332.75,95.6808],[1532131200000,7333.27,7339.85,7302.25,7318.25,130.7136],[1532132100000,7318.19,7326.74,7292.93,7322.7,118.6028],[1532133000000,7324.48,7324.67,7263.57,7280.42,95.4264],[1532133900000,7289.76,7295.1,7205.86,7235.28,133.7973],[1532134800000,7234.27,7272.9,7222.73,7252.06,103.4001],[1532135700000,7252.16,7265.51,7229.54,7250.09,114.4532],[1532136600000,7251.3,7273.04,7217.73,7273.04,49.1825],[1532137500000,7264,7269.79,7235.51,7262.78,11.048],[1532138400000,7263.26,7294.65,7250.17,7272.4,11.1763],[1532139300000,7272.4,7290.69,7262.8,7265.28,7.9835],[1532140320000,7279.73,7309.73,7275.96,7309.73,0.7308],[1532141100000,7305.38,7306.05,7279.25,7288.17,1.0497],[1532142060000,7287.8,7299.23,7280.75,7280.75,1.7682],[1532142900000,7280.75,7288.46,7259.59,7259.59,3.2704],[1532143860000,7261.44,7289.8,7255.71,7289.79,7.9442],[1532144700000,7286.43,7289.8,7276.51,7276.51,0.1776],[1532145660000,7286.62,7289.47,7254.89,7271,18.0418],[1532146560000,7282.43,7284.3,7270.78,7276.26,7.6911],[1532147400000,7273.69,7294.88,7269.55,7285.08,10.0929],[1532148360000,7285.08,7299.7,7279.78,7299.7,9.1132],[1532149200000,7299.7,7317.39,7291.64,7314.5,6.5247],[1532150100000,7327.36,7339.94,7305.87,7325.43,1.218],[1532151360000,7324.83,7328.77,7289.63,7328.77,6.8092],[1532151960000,7334.08,7337.78,7314.29,7337.78,4.4923],[1532152800000,7336.52,7346.46,7325.62,7326.64,14.0965],[1532153700000,7330.55,7342.85,7319.41,7339.87,8.1324],[1532154600000,7338.2,7376.33,7324.83,7376.33,6.4225],[1532155500000,7361.59,7371.78,7331.96,7343.97,1.4586],[1532156400000,7345.33,7354.81,7331.97,7331.97,3.3167],[1532157480000,7340.31,7352.41,7327.7,7346.48,7.0057],[1532158320000,7340.61,7344.61,7333.22,7334.11,0.5235],[1532159340000,7337.61,7343.38,7325.47,7325.47,0.2993],[1532160300000,7327.49,7334.34,7323.65,7323.65,0.2034],[1532160960000,7322.07,7332.7,7317.95,7325.16,2.3724],[1532161800000,7320.07,7330.74,7309.03,7311.28,8.6626],[1532162820000,7318.34,7325.51,7312.95,7323.72,2.7709],[1532163720000,7324.06,7326.01,7311.72,7321.61,0.3743],[1532164620000,7325.94,7339.49,7318.34,7330.02,0.8004],[1532165460000,7337.34,7347.92,7329.37,7329.37,0.3806],[1532166300000,7329.36,7335.22,7316.54,7335.22,5.3794],[1532167740000,7319.52,7322.53,7307.46,7322.11,2.6004],[1532168100000,7318.91,7322.11,7294.77,7312.63,7.0077],[1532169180000,7310.34,7315.01,7281.56,7298.74,0.9866],[1532169900000,7298.53,7327.69,7297.1,7304.46,10.5392],[1532170800000,7309.61,7315.91,7295.94,7295.94,4.4621],[1532172180000,7306.65,7314.68,7306.44,7307.39,4.5477],[1532172600000,7308.58,7312.96,7290.74,7311.18,5.8498],[1532173620000,7310.77,7334.59,7303.72,7329.6,7.0028],[1532174400000,7319.61,7328.98,7293.75,7321.99,3.5877],[1532175300000,7322.11,7324.48,7304.59,7307.11,5.6739],[1532176200000,7319.22,7335.33,7309.38,7335.33,13.4294],[1532177100000,7335.26,7347.93,7328.04,7328.51,7.244],[1532178120000,7346.02,7362.55,7336.49,7361.11,15.6496],[1532178960000,7361.8,7381.55,7349.69,7365.33,23.6034],[1532179800000,7373.63,7401.42,7362.49,7376.92,44.6742],[1532180700000,7375.48,7376.97,7350.37,7353.57,4.6749],[1532181600000,7356.15,7386.81,7353.63,7370,14.6462],[1532182500000,7385.33,7386.79,7357.61,7359.22,7.8538],[1532183400000,7363.18,7377.48,7357.64,7369.15,5.3354],[1532184300000,7365.79,7402.83,7348.83,7349.84,11.211],[1532185260000,7353.2,7370.46,7348,7370.46,4.2893],[1532186160000,7376.26,7386.7,7368.11,7368.21,23.9304],[1532187000000,7368.12,7404.2,7368.12,7393.26,3.8265],[1532187900000,7399.47,7423.75,7382.54,7386.54,2.9874],[1532188800000,7399.48,7430,7390.05,7403.07,544.1092],[1532189700000,7400.9,7411.99,7373.74,7385.29,4.2924],[1532190660000,7402.76,7419.52,7388.18,7410.87,151.78],[1532191560000,7411.8,7427.28,7403.7,7403.7,496.0485],[1532192400000,7403.5,7418.49,7385.16,7418.48,2.5058],[1532193300000,7416.32,7418.49,7389.66,7409.51,138.2519],[1532194320000,7413.05,7416.98,7400.99,7413.82,216.0687],[1532195160000,7409.79,7427.4,7400.83,7417.19,91.8373],[1532196000000,7416.82,7446.82,7410.72,7428.7,805.3219],[1532196900000,7431.78,7449.35,7427.28,7442.93,784.2265],[1532197980000,7437.02,7438.13,7410.08,7410.08,0.2159],[1532198700000,7420.88,7444.66,7410.26,7441.31,34.6791],[1532199600000,7444.73,7455.96,7426.06,7445.99,670.0688],[1532200500000,7434.77,7449.97,7412.3,7412.3,15.3567],[1532201400000,7412.29,7422.41,7398.48,7417.11,3.4739],[1532202300000,7414.99,7441.61,7413.04,7428.6,682.487],[1532203200000,7426.67,7488.14,7423.16,7436.28,466.909],[1532204100000,7436.26,7446.16,7424.65,7427.29,180.8864],[1532205000000,7434.95,7437.51,7418.65,7418.75,3.9917],[1532205960000,7420.17,7427.98,7414.61,7414.63,0.3094],[1532206800000,7425.16,7428.19,7415.07,7415.73,0.1703],[1532208720000,7427.36,7434.49,7409.94,7409.94,0.4463],[1532209500000,7409.95,7414.81,7399.91,7409,0.9191],[1532210460000,7408.58,7421.72,7407.96,7421.72,3.0689],[1532211360000,7413.17,7421.23,7399.91,7399.91,3.1484],[1532212380000,7407.46,7420.37,7402.64,7413,0.0229],[1532213100000,7419.98,7433.03,7410.12,7420.62,6.3379],[1532214480000,7421.02,7425.51,7413.97,7413.97,0.1991],[1532214900000,7413.97,7429.67,7411.4,7411.4,1.3798],[1532215800000,7423.45,7423.48,7409.73,7409.73,0.3473],[1532216700000,7412.47,7420.77,7400.67,7402.2,1.7782],[1532217600000,7402.5,7407.51,7343.46,7393.1,25.3054],[1532218500000,7392.84,7420.53,7392.52,7420.52,4.478],[1532219460000,7418.41,7438.45,7408.68,7427.4,5.331],[1532220360000,7429.84,7443.15,7424.69,7442.42,10.9692],[1532221320000,7438.62,7441.94,7400.02,7441.94,3.4098],[1532222100000,7437.27,7441.73,7421.76,7423.17,0.0916],[1532223180000,7438.1,7439.09,7423.19,7423.58,1.4943],[1532223900000,7433.11,7502.86,7424.37,7478.43,92.3884],[1532224800000,7473.88,7484.52,7453.71,7453.71,11.0762],[1532225700000,7463.37,7465.74,7429.26,7452.45,4.8139],[1532226600000,7440.65,7444.8,7400,7426.63,8.7467],[1532227500000,7423.8,7440.21,7414.2,7414.2,11.7027],[1532228460000,7419.94,7433,7403.91,7433,0.5492],[1532229360000,7425.24,7432.45,7403.97,7403.97,1.0597],[1532230200000,7407.43,7424.58,7402.23,7417.09,2.5715],[1532231160000,7414.18,7424.01,7402.45,7418.06,2.7695],[1532232000000,7416.88,7423.06,7397.24,7404.56,1.3969],[1532232900000,7409.38,7410.03,7373.73,7403.19,23.5868],[1532233800000,7397.5,7405.24,7388.99,7399.17,3.7858],[1532234760000,7408.77,7413.36,7396.5,7396.5,3.1266],[1532235600000,7401.39,7406.41,7384.98,7394.83,1.0072],[1532236500000,7394.4,7399.31,7388.85,7390.24,1.2796],[1532237400000,7402.22,7415.98,7398.74,7415.98,4.0482],[1532238300000,7407.92,7415.61,7402.03,7404.68,0.0306],[1532239200000,7415.95,7424.17,7405.19,7406.77,7.2282],[1532240160000,7418.4,7421.51,7393.25,7393.25,7.9344],[1532241420000,7387.48,7397.71,7376.33,7382.8,3.9178],[1532241900000,7382.49,7398.29,7371.25,7398.19,2.8506],[1532242860000,7398.74,7403.84,7385.19,7385.19,15.7907],[1532244000000,7393.76,7396.55,7385.17,7393.08,2.1829],[1532244600000,7397.08,7400.52,7393.18,7400.52,1.0322],[1532245560000,7397.6,7403.67,7386.69,7389.11,0.516],[1532246640000,7403.41,7424.17,7403.41,7409.83,6.0785],[1532247300000,7421.72,7430.4,7415.48,7416.54,10.9242],[1532248320000,7424.73,7449.08,7424.61,7436.41,14.6548],[1532249100000,7445.04,7449.08,7419.58,7442.57,21.9777],[1532250060000,7439,7441.12,7424.01,7435.43,1.5748],[1532250960000,7435.98,7442.55,7424.31,7427,25.2337],[1532251800000,7433.35,7443.24,7427,7442.74,0.6683],[1532252700000,7433.48,7442.85,7427.16,7442.76,0.2547],[1532253660000,7438.43,7443.24,7427,7429.72,0.6074],[1532254560000,7442.91,7448.37,7429.92,7448.37,1.33],[1532255400000,7444.14,7448.37,7443.34,7448.37,1.1068],[1532256960000,7448.39,7450.13,7448.38,7450.13,0.0457],[1532257260000,7450.28,7450.28,7450.28,7450.28,0.0276],[1532261700000,7450.3,7450.34,7450.28,7450.34,0.0152],[1532262600000,7450.47,7452.31,7427,7427.25,11.1202],[1532263500000,7430.2,7445.79,7427,7427,7.9888],[1532264400000,7428.03,7444.48,7427,7444.48,19.1764],[1532265300000,7438.92,7445.65,7437.93,7445.65,0.5805],[1532266200000,7433.36,7457.2,7427,7454.65,12.6974],[1532267100000,7451.17,7484.88,7431.17,7451.98,31.1422],[1532268000000,7456.9,7472.33,7451.69,7468.66,3.5794],[1532268900000,7455,7489.67,7455,7485.63,29.855],[1532269800000,7473.43,7510,7458.84,7487.57,9.9427],[1532270700000,7491.22,7520.98,7455,7468.58,32.2658],[1532271600000,7478.04,7525.9,7477.98,7497.49,18.3766],[1532272500000,7514.88,7550,7492.91,7519.27,7.9921],[1532273400000,7517.28,7549.69,7501.74,7526,26.373],[1532274300000,7515.78,7535.51,7492.47,7532.62,7.5989],[1532275200000,7516.29,7545.66,7500.23,7524.05,37.6064],[1532276100000,7513.68,7541.76,7505.04,7514.67,4.5521],[1532277000000,7527.08,7532.99,7504.75,7509.47,12.0993],[1532277900000,7509.47,7527.63,7485.29,7508.98,2.5171],[1532278800000,7501.48,7518.01,7485.36,7492,8.4935],[1532279700000,7486.02,7500,7485.19,7485.19,48.6127],[1532280600000,7490.59,7507.5,7484.96,7490.25,164.673],[1532281500000,7498.16,7506.65,7484.78,7485.11,64.2798],[1532282400000,7489.62,7504.67,7485.21,7495.95,7.9736],[1532283300000,7501.79,7520.88,7495.51,7496.68,357.3751],[1532284200000,7501.51,7517.09,7494.23,7513.08,1205.9311],[1532285100000,7511.59,7521.09,7503.86,7503.86,951.2312],[1532286000000,7514.24,7522.52,7493,7519.5,858.7604],[1532286900000,7521.52,7522.52,7502.58,7521.74,623.9526],[1532287800000,7521.55,7521.74,7507.03,7521.74,293.335],[1532288700000,7518.56,7526.01,7515.87,7526.01,136.3982],[1532289600000,7519.63,7527.86,7519.32,7525.86,168.8977],[1532290500000,7524.73,7533.03,7522.39,7531.24,1913.6092],[1532291400000,7532.16,7537.41,7513.91,7513.91,566.0583],[1532292300000,7527.51,7527.6,7513.86,7513.87,0.6117],[1532293200000,7531.25,7565.29,7524.51,7549.34,9.4272],[1532294100000,7550.75,7557.79,7317.28,7391.06,203.0904],[1532295000000,7385.65,7433.48,7382.86,7403.45,34.2607],[1532295900000,7407.22,7415.03,7356.97,7356.97,2.8546],[1532296800000,7368.7,7399.26,7345.56,7389.31,4.517],[1532297700000,7399.96,7409.75,7366.06,7387.95,18.8033],[1532298600000,7394,7404.63,7386.92,7404.63,10.0048],[1532299500000,7404.43,7430.54,7404.35,7420.59,10.6055],[1532300400000,7416.11,7419.9,7390.14,7390.15,2.1226],[1532301300000,7400.66,7406.91,7395,7402.01,0.2894],[1532302200000,7399.39,7416.38,7395.59,7416.38,0.4479],[1532303100000,7405.39,7416.38,7398.58,7402.92,1.0155],[1532304000000,7401.64,7431.03,7370.78,7421.35,11.0922],[1532304900000,7427.14,7450.73,7426.66,7446.11,2.4416],[1532305800000,7434.98,7450.73,7434.98,7447.31,0.5403],[1532306700000,7446.28,7502.29,7441.5,7478.85,5.5564],[1532307600000,7470.46,7470.95,7455.99,7455.99,0.7488],[1532308500000,7464.88,7473.75,7451.43,7458.09,3.1817],[1532309400000,7466.4,7500.32,7461.99,7496.96,13.25],[1532310300000,7482.25,7541.4,7477.84,7541.4,106.5443],[1532311200000,7529.8,7618.63,7505.72,7564.98,131.3337],[1532312100000,7568.93,7656.77,7564.91,7599.05,96.7966],[1532313000000,7598.86,7669.71,7593.27,7624.88,65.3716],[1532313900000,7636.23,7636.77,7604.67,7632,28.0671],[1532314800000,7629.26,7655.61,7596.01,7604.38,11.92],[1532315700000,7615.4,7641.46,7613.09,7626.58,9.6767],[1532316600000,7628.54,7638.2,7597.63,7616.6,51.1403],[1532317500000,7609.37,7627.55,7608.29,7620,25.404],[1532318400000,7614.69,7662.12,7613.3,7632.71,35.0583],[1532319300000,7630.2,7653.15,7626.08,7648.96,1.999],[1532320200000,7652.58,7691.2,7649,7691.2,36.3015],[1532321100000,7688.75,7708.24,7654.53,7673.14,57.3192],[1532322000000,7671.84,7680.68,7641.45,7641.54,12.2388],[1532322900000,7641.91,7669.71,7637.45,7662.28,9.7565],[1532323800000,7665.07,7669.16,7637.66,7645.85,15.813],[1532324700000,7653.73,7658.49,7637.53,7638.34,0.2075],[1532325600000,7655.43,7679.85,7652.81,7665.09,6.1926],[1532326500000,7676.9,7700.89,7662.73,7682.47,20.2931],[1532327400000,7678.05,7704.21,7659.58,7687.5,6.8304],[1532328300000,7684.21,7703.45,7665,7690.89,64.7719],[1532329200000,7690.88,7717.52,7651.75,7668.53,272.5404],[1532330100000,7662.59,7790.92,7652.83,7750.02,321.1265],[1532331000000,7750.41,7770.83,7724.35,7735.1,11.1983],[1532331900000,7743.98,7770.61,7736.2,7766.4,103.4901],[1532332800000,7766.65,7770.82,7731.98,7763.38,178.5686],[1532333700000,7763.38,7767.12,7708.21,7727.36,94.6661],[1532334600000,7734.22,7741.64,7682.31,7707.28,85.5],[1532335500000,7708.94,7738.49,7693.38,7717.56,132.0975],[1532336400000,7719.03,7720.05,7682.33,7705.33,95.1469],[1532337300000,7705.68,7708.11,7682.17,7687.97,141.642],[1532338200000,7688.28,7717.15,7685.65,7703.34,124.189],[1532339100000,7709.07,7725.26,7694.05,7724.52,71.5283],[1532340000000,7721.98,7737.35,7687.2,7720.85,118.181],[1532340900000,7721.14,7721.67,7705.22,7709.1,95.094],[1532341800000,7708.62,7710.03,7688.36,7694.82,88.5582],[1532342700000,7697.71,7700.45,7669.28,7687.84,82.6898],[1532343600000,7690.29,7718.87,7687.84,7707.49,76.4649],[1532344500000,7705.89,7707.87,7690.58,7701.5,74.7277],[1532345400000,7702.8,7703.84,7682.19,7689.04,94.6667],[1532346300000,7688.56,7691,7660.24,7688.8,77.2394],[1532347200000,7689.91,7696.9,7674.54,7689.55,89.3815],[1532348100000,7688.86,7695.43,7677.25,7684.51,90.9047],[1532349000000,7688.14,7690.73,7668.95,7682.67,87.1748],[1532349900000,7685.58,7707.87,7678.84,7705.75,81.4256],[1532350800000,7704.29,7720.8,7698.56,7709.65,84.5382],[1532351700000,7716.92,7729.13,7707.89,7719.47,105.7869],[1532352600000,7715.26,7723.71,7702.81,7719.8,93.6004],[1532353500000,7719.49,7728.16,7704.29,7722.14,61.4862],[1532354400000,7722.1,7734.14,7714.95,7725.96,92.7542],[1532355300000,7727.13,7729.2,7707.36,7715.22,119.1987],[1532356200000,7715.22,7715.77,7689.2,7696.16,86.7207],[1532357100000,7696.17,7729.19,7692.63,7705.68,67.0697],[1532358000000,7705.98,7725.89,7695.83,7695.83,74.67],[1532358900000,7698.25,7715.95,7692.47,7707.1,104.8538],[1532359800000,7706.18,7734.76,7704.73,7728.37,143.3263],[1532360700000,7724,7746.25,7719.72,7720.99,88.7021],[1532361600000,7727.26,7738.14,7696.08,7706.16,1111.1337],[1532362500000,7703.81,7746.12,7696.08,7746.1,150.6618],[1532363400000,7746.1,7746.12,7716.48,7734.21,527.3269],[1532364300000,7734.19,7744.1,7721.56,7743,191.4343],[1532365200000,7741.26,7746.27,7729.26,7729.27,479.6974],[1532366100000,7729.26,7736,7711.94,7727.87,122.3042],[1532367000000,7731.14,7733.35,7715.71,7723.91,129.9616],[1532367900000,7724.31,7740.08,7713.32,7727.34,142.7175],[1532368800000,7728.52,7754.27,7721.4,7750.37,158.0519],[1532369700000,7747.95,7791.76,7741.89,7752.87,530.7334],[1532370600000,7772.71,7823.4,7652.62,7739.3,597.2074],[1532371500000,7740.28,7776.81,7706.3,7752.73,216.6743],[1532372400000,7752.73,7781.14,7729.18,7781.14,356.8961],[1532373300000,7782.73,7794.55,7751.77,7778.9,1183.9404],[1532374200000,7777.51,7804.36,7737.3,7757.4,208.879],[1532375100000,7757.65,7781.91,7745.66,7752.33,94.9772],[1532376000000,7757.53,7769.82,7752.27,7767.16,139.4956],[1532376900000,7766.67,7768.36,7735.21,7735.33,338.5082],[1532377800000,7735.31,7753.85,7716.43,7747.54,162.2581],[1532378700000,7747.88,7751.68,7704.3,7717.48,126.5237],[1532379600000,7716.64,7745.86,7711.23,7738.54,156.7421],[1532380500000,7735.33,7742.16,7725.78,7740.26,276.9908],[1532381400000,7741.92,7780.85,7738.36,7754.08,313.1484],[1532382300000,7753.51,7766.99,7748.26,7765.17,722.762],[1532383200000,7765,7782.13,7757.41,7758,459.1567],[1532384100000,7758.16,7780.23,7751.71,7778.23,212.9414],[1532385000000,7776.31,7779.63,7746.14,7747.01,252.4077],[1532385900000,7746.42,7760.4,7724.76,7734.85,164.7786],[1532386800000,7734.74,7737.58,7710.25,7728.2,149.6766],[1532387700000,7728.39,7750.21,7722.66,7728.3,378.9604],[1532388600000,7727.11,7743.04,7713.57,7726.24,402.8389],[1532389500000,7730.29,7755.26,7713.59,7726.21,314.634],[1532390400000,7725.69,7744.01,7719.9,7727.15,179.4097],[1532391300000,7727.04,7731.64,7700.39,7725.63,162.0958],[1532392200000,7725.19,7734.51,7701.37,7717.76,158.2476],[1532393100000,7716.08,7733.4,7710.03,7729.79,206.6759],[1532394000000,7732.01,7742.87,7715.62,7728.6,275.7281],[1532394900000,7728.64,7750.33,7728.6,7748.33,333.1704],[1532395800000,7749.26,7777.77,7735.98,7760.76,463.2317],[1532396700000,7762.26,7773.33,7750.22,7757.51,309.3477],[1532397600000,7757.06,7781.27,7753.86,7776.67,135.8493],[1532398500000,7775.73,7781.25,7750.33,7764.62,205.0008],[1532399400000,7764.71,7764.88,7728.39,7732.48,158.6285],[1532400300000,7730.47,7752.51,7729.67,7747.5,180.3006],[1532401200000,7745.25,7766,7731.73,7761.03,430.3292],[1532402100000,7761.08,7781.12,7747.42,7769.4,349.5506],[1532403000000,7774.22,7811.82,7754.65,7811.82,623.0962],[1532403900000,7811.82,7820.01,7767.99,7791.2,271.4529],[1532404800000,7791.28,7800.28,7768.14,7791.63,115.2704],[1532405700000,7787.6,7806.35,7782.3,7793,148.6462],[1532406600000,7792.22,7845.64,7784.58,7831.53,192.6112],[1532407500000,7831.16,7880,7826.29,7868,153.5587],[1532408400000,7870.18,7950,7864.7,7949.1,175.9627],[1532409300000,7948.56,7976.11,7940,7970.33,160.6665],[1532410200000,7968.24,8000,7963.1,7997.89,198.6572],[1532411100000,7996.37,8037.96,7940.23,7983.66,243.6376],[1532412000000,7983.37,7984,7931.62,7959.62,147.2591],[1532412900000,7962.28,7980.36,7946.36,7971.99,152.4678],[1532413800000,7976.43,8015.42,7970.29,8001.09,161.91],[1532414700000,8003.65,8003.72,7970.53,7992.67,144.8601],[1532415600000,7992.72,8030.6,7990.15,8027.17,105.4257],[1532416500000,8028.87,8037.92,7988.78,8024.36,137.7036],[1532417400000,8024.24,8024.6,7996.39,8016.28,120.7288],[1532418300000,8016.72,8041.96,8012,8029.64,127.5479],[1532419200000,8029.73,8039.96,7990.11,7994.7,180.5229],[1532420100000,7991.41,8011.74,7986.57,7993.3,150.8557],[1532421000000,7993.3,7993.3,7957.73,7983,122.3033],[1532421900000,7987.84,7998.59,7960.7,7993.94,105.4227],[1532422800000,7997.01,8019.71,7979.8,7998.6,137.6863],[1532423700000,7998.19,8011.92,7992.79,7999.98,133.715],[1532424600000,8003.82,8024.5,7985.98,8021.52,122.9488],[1532425500000,8022.66,8042.06,7997.45,8027.3,135.9653],[1532426400000,8028.13,8033.63,8011.18,8026.83,113.4606],[1532427300000,8025.83,8050,8011.21,8040.97,190.8458],[1532428200000,8040.6,8122.13,8040.43,8084.1,160.62],[1532429100000,8085.64,8159,8083.47,8129.11,187.1162],[1532430000000,8133.92,8148.29,8090,8121.3,280.0122],[1532430900000,8121.44,8170.96,8120.48,8170.96,332.9125],[1532431800000,8168.43,8195.6,8155.13,8169.09,200.4039],[1532432700000,8167.79,8278,8166.3,8255.05,111.987],[1532433600000,8250.84,8401.66,8239.25,8330.83,313.8529],[1532434500000,8322.88,8325.23,8210.58,8222.51,247.268],[1532435400000,8219.78,8243.88,8144.48,8228.3,179.2755],[1532436300000,8232.8,8243.03,8190.5,8228.99,164.3525],[1532437200000,8228.96,8228.98,8153.58,8172.82,204.5382],[1532438100000,8177.47,8220.04,8157.48,8189.15,161.9487],[1532439000000,8188.88,8243.84,8181.24,8228,114.8297],[1532439900000,8225.99,8260.7,8214.3,8233.7,115.6905],[1532440800000,8233.57,8259.23,8208.9,8232.65,253.3474],[1532441700000,8243.79,8260.38,8177.11,8194.1,235.9707],[1532442600000,8193.81,8211.1,8168.64,8180.01,147.0112],[1532443500000,8182.74,8187.38,8127.78,8176.27,173.9369],[1532444400000,8169.26,8183.41,8116.55,8148.1,180.8266],[1532445300000,8149.99,8186.2,8136.26,8176.13,248.8412],[1532446200000,8172.52,8212.55,8167.61,8182.92,192.4064],[1532447100000,8182.86,8203.08,8166.68,8178.48,158.0679],[1532448000000,8178.75,8212.53,8175.39,8189.42,146.4027],[1532448900000,8188.22,8200.48,8154.86,8174.06,644.739],[1532449800000,8168.44,8198.99,8157.67,8174.62,171.6737],[1532450700000,8174.61,8183.96,8156.69,8177.55,226.7006],[1532451600000,8178.48,8212.57,8177.7,8195.7,582.5487],[1532452500000,8194.67,8256,8194.24,8237.75,144.0068],[1532453400000,8236.98,8279.2,8220.34,8247.34,270.1371],[1532454300000,8247.25,8267.78,8218.75,8249.8,492.0135],[1532455200000,8249.41,8250.52,8218.75,8218.75,132.6267],[1532456100000,8216.65,8244.61,8202.88,8243.08,107.5508],[1532457000000,8243.06,8252.11,8230.24,8248.75,142.3883],[1532457900000,8248.2,8281.12,8237.53,8251.09,356.4634],[1532458800000,8250.89,8298.99,8247.06,8296.61,531.1887],[1532459700000,8296.61,8298.93,8251.32,8262.67,433.861],[1532460600000,8263.77,8280.36,8254.41,8260.14,236.7087],[1532461500000,8258.64,8272.92,8249.25,8268.57,107.9281],[1532462400000,8271.81,8272.88,8217.74,8222.12,148.8293],[1532463300000,8222.71,8228.8,8196.79,8228.64,108.1697],[1532464200000,8236.81,8237.28,8230.83,8230.84,108.0544],[1532465100000,8230.83,8231.08,8205.13,8229.1,193.9937],[1532466000000,8229.5,8247.93,8213.95,8223.35,397.6964],[1532466900000,8223.63,8260.96,8209.15,8260.18,413.7255],[1532467800000,8260.22,8260.87,8239.6,8255.41,426.5864],[1532468700000,8254.54,8272.87,8247.97,8258.69,920.0332],[1532469600000,8257.89,8300.01,8254.61,8300.01,332.1624],[1532470500000,8296.56,8312.48,8269.46,8295.38,362.2542],[1532471400000,8293.09,8337.3,8292.39,8319.9,528.9924],[1532472300000,8318.04,8333.69,8295.99,8317.74,216.242],[1532473200000,8317.27,8350.44,8317.25,8324.26,345.8734],[1532474100000,8327.36,8365.96,8323.48,8356.47,138.0035],[1532475000000,8354.91,8451.02,8354.91,8441.78,214.1595],[1532475900000,8433.78,8489.08,8406.38,8407.4,302.1727],[1532476800000,8406.71,8459.11,8366.2,8447.13,154.7118],[1532477700000,8446.79,8485.38,8446.79,8476.54,131.0992],[1532478600000,8481.72,8482.14,8428.35,8433.89,294.8864],[1532479500000,8435.17,8460.51,8416.3,8416.31,218.2901],[1532480400000,8424.42,8436.64,8400,8434.43,278.582],[1532481300000,8434.43,8453.96,8433.9,8442.7,126.5727],[1532482200000,8441.98,8445.29,8400.11,8408.06,201.2989],[1532483100000,8409.22,8437,8400.08,8421.93,121.5308],[1532484000000,8421.93,8424.34,8328.86,8334.17,203.1157],[1532484900000,8337.29,8361.13,8314.51,8360.27,111.9691],[1532485800000,8360,8360.5,8336.18,8336.24,150.2896],[1532486700000,8336.25,8354.44,8320.23,8338.87,162.0336],[1532487600000,8338.04,8339.91,8295.83,8336.3,205.0676],[1532488500000,8322.96,8344.97,8311.56,8311.77,174.4791],[1532489400000,8311.68,8354.4,8288.49,8346.54,568.5689],[1532490300000,8339.39,8367.22,8338.67,8365.39,297.3942],[1532491200000,8363.66,8366.26,8335.87,8351.93,119.6423],[1532492100000,8354.83,8375.54,8304.56,8356.52,141.7329],[1532493000000,8353.72,8383.7,8339.78,8383.7,137.0955],[1532493900000,8380.3,8410.97,8360.92,8398.8,182.7152],[1532494800000,8399.33,8421.19,8386.78,8397,139.3606],[1532495700000,8395.92,8410.03,8382.06,8383.12,144.9221],[1532496600000,8382.15,8417,8373.88,8417,122.4674],[1532497500000,8407.78,8435.45,8389.47,8428.16,205.4568],[1532498400000,8426.38,8435.16,8360.62,8373.69,246.0526],[1532499300000,8373.9,8380.93,8322.71,8357.34,198.9386],[1532500200000,8359.53,8360.87,8302.83,8302.84,203.7537],[1532501100000,8305.47,8351.26,8301.95,8345.29,105.5585],[1532502000000,8341.95,8351.22,8322.03,8332.18,136.1324],[1532502900000,8347.78,8360.86,8332.18,8360.86,60.0433],[1532503800000,8360.55,8360.86,8321.41,8338.31,116.8328],[1532504700000,8335.66,8354.39,8319.23,8328.2,128.1588],[1532505600000,8330.37,8330.39,8278.58,8292,146.8739],[1532506500000,8292.49,8318.92,8256.75,8292.8,166.7389],[1532507400000,8294.67,8323.18,8272.52,8297.23,142.3269],[1532508300000,8297.54,8306.05,8272.82,8295.58,130.6429],[1532509200000,8292.82,8292.84,8236.35,8244.11,174.5876],[1532510100000,8244.1,8244.13,8214.96,8244.09,150.2206],[1532511000000,8239.14,8269.99,8229.62,8230.39,134.4256],[1532511900000,8230.39,8247.03,8203,8214.2,186.8242],[1532512800000,8214.23,8222.5,8127.81,8166.89,299.8579],[1532513700000,8169.43,8181.75,8124.62,8146.83,166.7896],[1532514600000,8155.73,8177.93,8142.83,8174.44,118.9145],[1532515500000,8174.95,8226.73,8174.95,8216.19,100.8114],[1532516400000,8220.06,8225.84,8180,8190.78,163.1298],[1532517300000,8194.11,8237.3,8193.91,8202.56,129.6098],[1532518200000,8208.64,8221.5,8204.84,8221.5,109.9594],[1532519100000,8223.55,8224.34,8182.47,8182.47,224.8939],[1532520000000,8182.46,8220.06,8182.46,8206.72,119.6292],[1532520900000,8207.83,8228.28,8191,8210.23,116.2912],[1532521800000,8213.65,8215.72,8186.21,8188.81,136.1688],[1532522700000,8196.46,8201.29,8184.68,8194.05,136.6763],[1532523600000,8200.38,8230.81,8195.81,8224.58,153.9023],[1532524500000,8221.75,8230.06,8200.6,8206.3,157.8988],[1532525400000,8203.26,8215.42,8147.22,8210.16,198.4405],[1532526300000,8210.16,8210.66,8172.54,8198.89,154.1488],[1532527200000,8198.01,8201.92,8178,8183.2,135.8602],[1532528100000,8184.19,8189.34,8153.57,8174.4,152.4816],[1532529000000,8175.94,8187.91,8156.76,8171.42,132.6099],[1532529900000,8174.83,8198.8,8159.28,8191.9,135.0604],[1532530800000,8186,8198.8,8159.94,8178.46,166.7711],[1532531700000,8174.78,8176.07,8106.94,8113.63,160.584],[1532532600000,8111.09,8117.69,8050.1,8086.4,209.8173],[1532533500000,8078.19,8103.29,8033.18,8102.25,163.2718],[1532534400000,8105.51,8105.52,8065.31,8084.11,398.8665],[1532535300000,8084.77,8141.84,8082.56,8137.68,831.9172],[1532536200000,8137.26,8159.43,8125.99,8150.7,1069.3332],[1532537100000,8147.27,8187.13,8140.22,8162.65,703.9215],[1532538000000,8164.8,8167,8143.15,8150.25,808.6611],[1532538900000,8154.16,8165.88,8129.05,8160.36,638.6134],[1532539800000,8159.22,8165,8089.05,8121.46,280.6102],[1532540700000,8117.86,8124.99,8099.95,8122.29,140.3513],[1532541600000,8122.91,8144.66,8118.16,8138.1,162.3765],[1532542500000,8143.24,8144.46,8109.76,8114.56,458.5214],[1532543400000,8114.62,8117.89,8076.04,8084.22,153.2067],[1532544300000,8087.62,8091.18,8065.86,8084.28,170.7612],[1532545200000,8084.27,8111.83,8084.02,8110.9,155.499],[1532546100000,8110.24,8134.13,8094.85,8134.13,251.6866],[1532547000000,8128.02,8139.7,8100,8133.3,231.932],[1532547900000,8128,8161.48,8126.9,8161.48,144.6692],[1532548800000,8160.59,8174.55,8121.84,8140.7,238.8826],[1532549700000,8140.27,8141.49,8126.95,8141.29,188.3143],[1532550600000,8147,8157.43,8138.94,8154.28,137.1881],[1532551500000,8154.12,8199.9,8140.23,8192.41,147.2218],[1532552400000,8197.93,8232.08,8178.09,8206.64,104.6938],[1532553300000,8224.77,8278.3,8224.77,8270.58,110.9184],[1532554200000,8271.34,8325,8226.37,8264.31,149.8563],[1532555100000,8261.7,8297.74,8231.74,8287.6,79.0142],[1532556000000,8293.9,8297.74,8253.85,8263.11,177.5703],[1532556900000,8264.39,8283.47,8246.26,8271.09,144.4114],[1532557800000,8275.16,8325,8250.84,8264.14,164.1696],[1532558700000,8266.17,8271.15,8240.85,8264.17,125.6551],[1532559600000,8263.13,8291.77,8246.67,8279.2,96.7922],[1532560500000,8278.95,8281.74,8224.13,8231.12,140.6169],[1532561400000,8238.79,8239.32,8174.11,8204.82,167.0853],[1532562300000,8203.97,8213.32,8157.56,8172.38,179.1386],[1532563200000,8172.32,8213.3,8172.19,8193.56,120.0531],[1532564100000,8203.72,8211.43,8182.47,8195.25,103.7303],[1532565000000,8192.71,8250.05,8177.15,8241.84,129.5109],[1532565900000,8236.64,8253.9,8210.32,8234.22,147.168],[1532566800000,8230.62,8245.41,8228.58,8236.7,123.7504],[1532567700000,8237.8,8245.41,8178.42,8215.5,111.0392],[1532568600000,8214.59,8240.64,8194.84,8214.59,135.9335],[1532569500000,8212.81,8220.66,8201.01,8219.6,77.3413],[1532570400000,8219.53,8219.57,8169.8,8183.88,142.9766],[1532571300000,8185.99,8199.53,8157.82,8169.05,147.6559],[1532572200000,8170.77,8208.49,8157.06,8201.74,123.8239],[1532573100000,8203.31,8207.8,8179.6,8186.9,165.9705],[1532574000000,8181.78,8198.17,8178.84,8186.08,155.2035],[1532574900000,8184.54,8206.31,8161.88,8198.55,164.9329],[1532575800000,8198.63,8206.55,8183.68,8201.07,59.3788],[1532576700000,8201.5,8251.23,8196.96,8220.89,169.7999],[1532577600000,8221.93,8239.57,8216.97,8216.97,122.4266],[1532578500000,8216.96,8227.66,8206.09,8207.94,88.5117],[1532579400000,8207.95,8214.72,8191.22,8203.15,180.0788],[1532580300000,8202.58,8230.01,8201.2,8215.22,125.2087],[1532581200000,8222.17,8236.25,8215.63,8227.47,150.498],[1532582100000,8227.37,8227.47,8202.52,8209.25,138.641],[1532583000000,8210.73,8214.55,8192.09,8193.8,130.0914],[1532583900000,8194.97,8205.25,8182.89,8196.72,158.9254],[1532584800000,8198.54,8200.7,8184.08,8198.05,128.3344],[1532585700000,8199.41,8226.25,8192.85,8210.93,127.0978],[1532586600000,8213.45,8251.04,8205.65,8240.86,127.3989],[1532587500000,8238.6,8286.1,8229.26,8266,142.9897],[1532588400000,8265.41,8293.99,8241.13,8257.74,329.5998],[1532589300000,8255.99,8280.91,8253.85,8267.74,149.6233],[1532590200000,8270.95,8272.78,8194.24,8230.18,226.2865],[1532591100000,8212.76,8247.3,8195.16,8237.02,151.5423],[1532592000000,8238.74,8257.78,8221.79,8253.3,122.8675],[1532592900000,8257.23,8269.49,8196.13,8238.9,139.2381],[1532593800000,8237.91,8265.68,8222.91,8265.68,94.6806],[1532594700000,8265.72,8265.72,8232.28,8242.4,161.6769],[1532595600000,8249.81,8261.06,8236.31,8258.33,94.916],[1532596500000,8259.48,8291.7,8254.75,8288.36,124.5404],[1532597400000,8290.19,8300,8248.78,8257.69,159.4959],[1532598300000,8264.18,8270.82,8253.51,8264.8,130.5107],[1532599200000,8264,8293.57,8259.63,8284.44,112.1731],[1532600100000,8292.64,8300,8275.02,8289.54,139.6013],[1532601000000,8292.84,8300,8253,8275.88,126.4854],[1532601900000,8277.06,8291.73,8260.49,8291.48,148.0511],[1532602800000,8291.8,8293.83,8259.87,8259.87,110.4016],[1532603700000,8255.64,8263.19,8220.04,8245.54,110.888],[1532604600000,8245.54,8246.97,8227.04,8227.52,135.5266],[1532605500000,8227.79,8264.92,8222.11,8243.2,113.5275],[1532606400000,8242.5,8251.43,8205.37,8226.64,147.4808],[1532607300000,8227.35,8231,8200,8209.48,240.4637],[1532608200000,8202.26,8225.21,8180.75,8212.21,159.6421],[1532609100000,8212.9,8238.01,8212.63,8233.08,96.9531],[1532610000000,8232.4,8237.18,8221.51,8232.32,132.6453],[1532610900000,8230.34,8247.44,8222.92,8224.62,107.5973],[1532611800000,8223.32,8231.11,8199.42,8203.14,173.9981],[1532612700000,8209.75,8210.11,8191.06,8208.8,132.0571],[1532613600000,8219.88,8221.07,8188.24,8191.68,157.8507],[1532614500000,8191.78,8200.39,8181.64,8191.39,191.2116],[1532615400000,8194.32,8219.69,8189.79,8201.67,131.4234],[1532616300000,8201.2,8230.22,8192.54,8230.22,119.8536],[1532617200000,8230.22,8230.23,8204.36,8208.37,128.8761],[1532618100000,8205.78,8224.88,8204.84,8208.3,159.5841],[1532619000000,8208.73,8219.92,8196.71,8215.7,117.9994],[1532619900000,8219.89,8220.17,8202.3,8207.87,150.7237],[1532620800000,8207.47,8216.79,8188.65,8192.83,132.6316],[1532621700000,8193.09,8214.46,8190.36,8205.92,142.1388],[1532622600000,8203.35,8213.34,8183.33,8199.99,99.6227],[1532623500000,8199.25,8208.45,8199.06,8205.38,19.0156],[1532624400000,8204.85,8213.69,8202.53,8213.69,139.2879],[1532625300000,8213.77,8239.02,8213.7,8236.4,101.9408],[1532626200000,8235.83,8254.96,8215,8234.34,111.8816],[1532627100000,8238.27,8238.68,8215,8225.2,84.368],[1532628000000,8220.51,8233.96,8215.02,8224.93,128.834],[1532628900000,8224.29,8240.11,8214.97,8238.3,91.3424],[1532629800000,8236.99,8242.6,8228.2,8237.7,121.2431],[1532630700000,8235.57,8242.05,8235.57,8240.04,160.4498],[1532631600000,8239.58,8243.62,8228.36,8235.9,109.6137],[1532632500000,8240.06,8240.35,8227.47,8230.36,159.9452],[1532633400000,8229.75,8245,8227.01,8245,87.792],[1532634300000,8245,8272.69,8243.63,8267.02,89.9991],[1532635200000,8265.75,8267.07,8242.76,8264.66,127.6503],[1532636100000,8265.46,8288.45,8261.5,8277.8,103.5522],[1532637000000,8277.86,8298.15,8272.04,8292.44,106.8659],[1532637900000,8291.8,8291.81,8129.07,8149.72,249.4908],[1532638800000,8150,8156.42,8080.3,8134.21,180.6265],[1532639700000,8128.89,8134.21,8081.79,8091.25,117.223],[1532640600000,8094.21,8103.71,7980,8029.38,148.0245],[1532641500000,8029.42,8031.26,7927.42,7988.26,136.7045],[1532642400000,7987.31,8029.98,7960.18,7995.15,157.563],[1532643300000,7995.15,8050.3,7989.89,7992.8,147.5287],[1532644200000,7993.73,8017.81,7915.83,7923.5,144.3312],[1532645100000,7923.86,7981.22,7911.93,7919.72,182.2124],[1532646000000,7916.67,7917.3,7856.2,7862.8,166.5602],[1532646900000,7857.35,7903.26,7826.01,7897.24,569.2162],[1532647800000,7895.27,7936.09,7890.87,7936.09,112.5831],[1532648700000,7942.06,7958.88,7916.13,7936.56,124.0102],[1532649600000,7936.41,7955.07,7932.36,7933.89,122.2849],[1532650500000,7933.44,7938.74,7905.96,7908.8,150.4368],[1532651400000,7909.53,7925.19,7894.96,7915.61,175.7495],[1532652300000,7915.25,7915.99,7896.82,7908.91,106.567],[1532653200000,7908.91,7939.4,7905.9,7920.55,141.841],[1532654100000,7920.56,7929.07,7906.2,7911.53,141.1697],[1532655000000,7910.77,7912.54,7863.4,7876.9,191.0234],[1532655900000,7876.16,7904.85,7864.7,7899.45,200.4764],[1532656800000,7898.29,7916.26,7891.82,7913.33,249.0504],[1532657700000,7913.67,7925.29,7900.87,7908.4,331.2805],[1532658600000,7913.54,7915.03,7900.2,7909.54,5.4357]]
     * moneyType : USDT
     */

    private String symbol;//卖出货币
    private String moneyType;//买入货币
    private List<List<String>> data;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}