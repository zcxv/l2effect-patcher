class 1175 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect42
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.el_aqua_swirl_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect43
		AttachOn=AM_LA
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.el_aqua_swirl_pr'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect46
		EffectClass=Class'LineageEffect.el_aqua_swirl_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect48
		AttachOn=AM_LA
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.el_aqua_swirl_pt'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect45
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_aqua_swirl_ta'
	End Object
	Desc="아쿠아 스월" //Aqua Swirl
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect42',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect43',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect46',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect48',SpecificStage=0)
	ExplosionActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect45',SpecificStage=0)
	FlyingTime=0.400000
}