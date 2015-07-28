class 4607 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect25
		AttachOn=AM_LH
		AttachBoneName="Bone01"
		bAbsolute=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.el_flame_strike_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect28
		AttachOn=AM_LH
		AttachBoneName="Bone09"
		bAbsolute=True
		offset=(X=0.000000,Y=-10.000000,Z=-10.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.el_flame_strike_pr'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect27
		offset=(X=1.000000,Y=0.000000,Z=0.500000)
		EffectClass=Class'LineageEffect.el_flame_strike_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect29
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
	End Object
	Desc="Magma Attack" //Magma Attack
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect25',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect28',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect27',SpecificStage=0)
	ExplosionActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect29',SpecificStage=0)
	FlyingTime=0.400000
}